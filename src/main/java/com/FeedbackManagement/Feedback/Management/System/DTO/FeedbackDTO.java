package com.FeedbackManagement.Feedback.Management.System.DTO;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class FeedbackDTO {
    private Long id;
    private Long userId;
    private String comments;
    private int rating;

    public int getRatings() {
        return rating;
    }

    public void setRatings(Object ratings) {
    }
}
