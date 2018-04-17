package com.greenfoxacademy.restbackend.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void doubling_whenInputIs10ThanExpectingAResultOf20() throws Exception{
    mockMvc.perform(get("/doubling?input=10"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.result").value(20));
  }

  @Test
  public void doubling_whenInputIsNullThanExpectingAnErrorMessage() throws Exception{
    mockMvc.perform(get("/doubling"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.error").value("Please provide an input!"));
  }

  @Test
  public void greeter_whenNameAndTitleIsNotNullThanExpectingGreet() throws Exception{
    mockMvc.perform(get("/greeter?name=laca&title=student"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.welcome_message").value("Oh, hi there laca, my dear student!"));
  }
}
