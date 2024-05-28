package com.FeedbackManagement.Feedback.Management.System.Controller;
import com.FeedbackManagement.Feedback.Management.System.DTO.FeedbackDTO;
import com.FeedbackManagement.Feedback.Management.System.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submit")
    public FeedbackDTO submitFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        return feedbackService.submitFeedback(feedbackDTO);
    }

    @GetMapping("/all")
    public List<FeedbackDTO> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/user/{userId}")
    public List<FeedbackDTO> getFeedbackByUserId(@PathVariable Long userId) {
        return feedbackService.getFeedbackByUserId(userId);
    }
}

