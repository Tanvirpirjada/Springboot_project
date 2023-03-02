package com.example.Chat_application.dao;


import com.example.Chat_application.model.ChatHistory;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChatHistoryRepository extends JpaRepository<ChatHistory, Integer> {

    @Query(value = "select * from chat_tbl where (sender_id= :user1 and receiver_id= :user2) or (sender_id= :user2 and receiver_id= :user1) and status_id=1 order by created_time",nativeQuery = true)
    public List<ChatHistory> getConversation(int user1,int user2);
}
