package ru.stc.dantes.clientapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.stc.dantes.clientapi.service.TimeSlotService;

@SpringBootTest
@AutoConfigureMockMvc
public class TimetableControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private TimeSlotService timeSlotService;

    void getAvailableSlots_ShouldReturnAvailableSlots() throws Exception {

    }
}
