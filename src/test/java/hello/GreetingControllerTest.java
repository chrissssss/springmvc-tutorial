package hello;

import org.apache.commons.text.StringEscapeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:servlet.xml"})
public class GreetingControllerTest extends SpringControllerTest {

    @Test
    public void shouldReturnHelloWorld() throws Exception {
        mockMvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World!")))
        ;
    }

    @Test
    public void shouldReturnGreetingContainingName() throws Exception {
        final String name = "my name is: Slim Shady";
        mockMvc.perform(
                get("/greeting")
                        .param("name", name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, " + name + "!")))
        ;
    }

    @Test
    public void shouldReturnGreetingWithEscapedHtmlTags() throws Exception {
        final String name = "my name is: <b>Slim Shady</b>";
        mockMvc.perform(
                get("/greeting")
                        .param("name", name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, " + StringEscapeUtils.escapeHtml4(name) + "!")))
        ;
    }

}