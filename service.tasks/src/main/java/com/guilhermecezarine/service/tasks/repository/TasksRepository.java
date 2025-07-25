package com.guilhermecezarine.service.tasks.repository;

import com.guilhermecezarine.service.tasks.domain.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TasksEntity, Long> {
    @Query("SELECT task FROM Task task WHERE task.dueDate <= :deadLine AND task.notified = false")
    List<TasksEntity> findTasksDueWithinDeadline(LocalDateTime deadLine);
}
