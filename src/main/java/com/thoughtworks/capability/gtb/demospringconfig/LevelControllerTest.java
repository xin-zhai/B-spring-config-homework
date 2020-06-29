package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(classes = DemoSpringConfigApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(
        properties = {
                "levelNumber=1"
        }
)
public class LevelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetAdvanced() throws Exception {
        String getLevelResult = mockMvc.perform(MockMvcRequestBuilders.get("/level"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assert.assertEquals(getLevelResult, "advanced");
    }
}
