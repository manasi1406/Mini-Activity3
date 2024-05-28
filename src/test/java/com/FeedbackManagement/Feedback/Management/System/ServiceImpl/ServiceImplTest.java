package com.FeedbackManagement.Feedback.Management.System.ServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.FeedbackManagement.Feedback.Management.System.DTO.FeedbackDTO;
import com.FeedbackManagement.Feedback.Management.System.Entity.FeedbackEntity;
import com.FeedbackManagement.Feedback.Management.System.Repository.FeedbackRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ServiceImplTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackServiceImpl feedbackService;

    @Before("")
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFeedBacks() {
        // Mocking behavior of the repository
        List<FeedbackEntity> feedbackEntities = new ArrayList<>();
        feedbackEntities.add(new FeedbackEntity());
        when(feedbackRepository.findAll()).thenReturn(feedbackEntities);

        // Calling the service method
        List<FeedbackEntity> result = feedbackService.getFeedBacks();

        // Verifying the result

    }

    @Test
    public void testSubmitFeedback() {
        // Create a DTO
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setUserId(101L);
        feedbackDTO.setComments("Test");
        feedbackDTO.setRatings(5);

        // behavior of the repository
        FeedbackEntity savedEntity = new FeedbackEntity();
        savedEntity.setUserId(101L);
        savedEntity.setComments("Test");
        savedEntity.setRatings(5);
        when(feedbackRepository.save(any(FeedbackEntity.class))).thenReturn(savedEntity);

        // Calling the service method
        FeedbackDTO result = feedbackService.submitFeedback(feedbackDTO);

        // Verifying the result
        assertEquals(feedbackDTO.getUserId(), result.getUserId());
        assertEquals(feedbackDTO.getComments(), result.getComments());
        assertEquals(feedbackDTO.getRatings(), result.getRatings());
    }
        @Test
        public void testGetAllFeedback() {
            // behavior of the repository
            List<FeedbackEntity> feedbackEntities = new ArrayList<>();
            feedbackEntities.add(new FeedbackEntity());
            feedbackEntities.add(new FeedbackEntity());
            when(feedbackRepository.findAll()).thenReturn(feedbackEntities);

            // Calling the service method
            List<FeedbackDTO> result = feedbackService.getAllFeedback();

            // Verifying the result

        }

        @Test
        public void testGetFeedbackByUserId() {
            // Mocking behavior of the repository
            List<FeedbackEntity> feedbackEntities = new ArrayList<>();
            feedbackEntities.add(new FeedbackEntity());
            feedbackEntities.add(new FeedbackEntity());
            when(feedbackRepository.findByUserId(1L)).thenReturn(feedbackEntities);

            // Calling the service method
            List<FeedbackDTO> result = feedbackService.getFeedbackByUserId(1L);

            // Verifying the result

        }
    }
