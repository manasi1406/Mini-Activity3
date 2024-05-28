package com.FeedbackManagement.Feedback.Management.System.ServiceImpl;

import com.FeedbackManagement.Feedback.Management.System.DTO.FeedbackDTO;
import com.FeedbackManagement.Feedback.Management.System.Entity.FeedbackEntity;
import com.FeedbackManagement.Feedback.Management.System.Repository.FeedbackRepository;
import com.FeedbackManagement.Feedback.Management.System.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
    @Override
    public List<FeedbackEntity> getFeedBacks() {
        return feedbackRepository.findAll();
    }
    @Override
    public FeedbackDTO submitFeedback(FeedbackDTO feedbackDTO) {
        FeedbackEntity feedbackEntity = new FeedbackEntity();
        feedbackEntity.setUserId(feedbackDTO.getUserId());
        feedbackEntity.setComments(feedbackDTO.getComments());
        feedbackEntity.setRatings(feedbackDTO.getRatings());
        FeedbackEntity savedEntity = feedbackRepository.save(feedbackEntity);
        return convertToDTO(savedEntity);
    }
    @Override
    public List<FeedbackDTO> getAllFeedback() {
        List<FeedbackEntity> feedbackEntities = feedbackRepository.findAll();
        List<FeedbackDTO> feedbackDTOs = new ArrayList<>();
        for (FeedbackEntity entity : feedbackEntities) {
            feedbackDTOs.add(convertToDTO(entity));
        }
        return feedbackDTOs;
    }

    @Override
    public List<FeedbackDTO> getFeedbackByUserId(Long userId) {
        List<FeedbackEntity> feedbackEntities = feedbackRepository.findByUserId(userId);
        List<FeedbackDTO> feedbackDTOs = new ArrayList<>();
        for (FeedbackEntity entity : feedbackEntities) {
            feedbackDTOs.add(convertToDTO(entity));
        }
        return feedbackDTOs;
    }

    private FeedbackDTO convertToDTO(FeedbackEntity entity) {
        FeedbackDTO dto = new FeedbackDTO();
        dto.setUserId(entity.getUserId());
        dto.setComments(entity.getComments());
        dto.setRatings(entity.getRatings());
        return dto;
    }
}
