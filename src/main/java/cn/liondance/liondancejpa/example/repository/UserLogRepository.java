package cn.liondance.liondancejpa.example.repository;

import cn.liondance.liondancejpa.example.entity.User;
import cn.liondance.liondancejpa.example.entity.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;


/**
 * The interface User repository.
 */
public interface UserLogRepository extends JpaRepository<UserLog, String> {

    @Override
    @Async
    <S extends UserLog> S save(S entity);
}
