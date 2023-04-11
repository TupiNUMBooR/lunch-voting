package ru.tupi.lunchvoting.web;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.MediaTypes;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.tupi.lunchvoting.TestData.ADMIN_EMAIL;

public class RootControllerTest extends AbstractControllerTest {
    @Test
    @WithUserDetails(value = ADMIN_EMAIL)
    void get() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaTypes.HAL_JSON_VALUE));
//                    .andExpect(result ->
//                            assertThat(JsonUtil.readValue(getContent(result), clazz))
//                                    .usingRecursiveComparison().ignoringFields()
//                                    .isEqualTo(user));
    }

    @Test
    void getUnAuth() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(status().isUnauthorized());
    }
}
