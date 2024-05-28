package com.FeedbackManagement.Feedback.Management.System.Service;

import com.FeedbackManagement.Feedback.Management.System.DTO.FeedbackDTO;
import com.FeedbackManagement.Feedback.Management.System.Entity.FeedbackEntity;

import java.util.List;

public interface FeedbackService {

    List<FeedbackEntity> getFeedBacks();

    FeedbackDTO submitFeedback(FeedbackDTO feedbackDTO);

    List<FeedbackDTO> getAllFeedback();

    List<FeedbackDTO> getFeedbackByUserId(Long userId);

}

