package io.github.mbarre.springbootauthjwt.repository;

import io.github.mbarre.springbootauthjwt.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
