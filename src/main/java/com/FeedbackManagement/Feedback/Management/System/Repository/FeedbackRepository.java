package com.FeedbackManagement.Feedback.Management.System.Repository;
import com.FeedbackManagement.Feedback.Management.System.Entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long> {
    List<FeedbackEntity> findByUserId(Long userId);


}
