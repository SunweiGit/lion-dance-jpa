package cn.liondance.liondancejpa.example.controller;

import cn.liondance.liondancejpa.example.entity.User;
import cn.liondance.liondancejpa.example.entity.UserLog;
import cn.liondance.liondancejpa.example.repository.UserLogRepository;
import cn.liondance.liondancejpa.example.repository.UserRepository;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.stream.Stream;

/**
 * The type User controller.
 *
 * @author sunwei
 */
@Api(tags = "用户")
@RestController
@RequestMapping(value = "user")
@AllArgsConstructor
public class UserController {
    private final UserRepository    userRepository;
    private final UserLogRepository userLogRepository;

    /**
     * Save.
     *
     * @param user the user
     */
    @ApiOperation(value = "保存")
    @PostMapping(value = "save")
    public void save(@RequestBody User user) {
        userRepository.save(user);
        userLogRepository.save(UserLog.builder().userInfo(JSON.toJSONString(user)).createTime(LocalDateTime.now()).event("save").build());
    }

    /**
     * Find all response entity.
     *
     * @return the response entity
     */
    @ApiOperation(value = "查询全部")
    @GetMapping(value = "findAll")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }


    /**
     * Find by name response entity.
     *
     * @param name the name
     * @return the response entity
     */
    @ApiOperation(value = "findByName")
    @GetMapping(value = "findByName")
    public ResponseEntity<List<User>> findByName(String name) {
        return ResponseEntity.ok(userRepository.findByName(name));
    }

    /**
     * Find by name and email response entity.
     *
     * @param name  the name
     * @param email the email
     * @return the response entity
     */
    @ApiOperation(value = "findByNameAndEmail")
    @GetMapping(value = "findByNameAndEmail")
    public ResponseEntity<List<User>> findByNameAndEmail(String name, String email) {
        return ResponseEntity.ok(userRepository.findByNameAndEmail(name, email));
    }


    /**
     * Find by email in response entity.
     *
     * @param email the email
     * @return the response entity
     */
    @ApiOperation(value = "findByEmailIn")
    @GetMapping(value = "findByEmailIn")
    public ResponseEntity<List<User>> findByEmailIn(String... email) {
        return ResponseEntity.ok(userRepository.findByEmailIn(email));
    }


    /**
     * Page request sort response entity.
     *
     * @param page      the page
     * @param size      the size
     * @param direction the direction
     * @param orderBy   the order by
     * @return the response entity
     */
    @ApiOperation(value = "pageRequestSort")
    @GetMapping(value = "pageRequestSort")
    public ResponseEntity<Page<User>> pageRequestSort(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String direction, @RequestParam String... orderBy) {
        return ResponseEntity.ok(userRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(direction), orderBy))));
    }

    /**
     * Page request response entity.
     *
     * @param page the page
     * @param size the size
     * @return the response entity
     */
    @ApiOperation(value = "pageRequest")
    @GetMapping(value = "pageRequest")
    public ResponseEntity<Page<User>> pageRequest(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(userRepository.findAll(PageRequest.of(page, size)));
    }

    /**
     * Sort response entity.
     *
     * @param direction the direction
     * @param orderBy   the order by
     * @return the response entity
     */
    @ApiOperation(value = "sort")
    @GetMapping(value = "sort")
    public ResponseEntity<List<User>> sort(@RequestParam String direction, @RequestParam String... orderBy) {
        return ResponseEntity.ok(userRepository.findAll(Sort.by(Sort.Direction.valueOf(direction), orderBy)));
    }

    /**
     * Remove by name equals response entity.
     *
     * @param name the name
     * @return the response entity
     */
    @ApiOperation(value = "removeByNameEquals")
    @GetMapping(value = "removeByNameEquals")
    public ResponseEntity<Long> removeByNameEquals(@RequestParam String name) {
        return ResponseEntity.ok(userRepository.removeByNameEquals(name));
    }

    /**
     * Delete by name equals response entity.
     *
     * @param name the name
     * @return the response entity
     */
    @ApiOperation(value = "deleteByNameEquals")
    @GetMapping(value = "deleteByNameEquals")
    public ResponseEntity<Long> deleteByNameEquals(@RequestParam String name) {
        return ResponseEntity.ok(userRepository.deleteByNameEquals(name));
    }

    /**
     * Count by name equals response entity.
     *
     * @param name the name
     * @return the response entity
     */
    @ApiOperation(value = "countByNameEquals")
    @GetMapping(value = "countByNameEquals")
    public ResponseEntity<Long> countByNameEquals(@RequestParam String name) {
        return ResponseEntity.ok(userRepository.countByNameEquals(name));
    }

    /**
     * Gets by name equals.
     *
     * @param name the name
     * @return the by name equals
     */
    @ApiOperation(value = "getByNameEquals")
    @GetMapping(value = "getByNameEquals")
    public ResponseEntity<List<User>> getByNameEquals(@RequestParam String name) {
        return ResponseEntity.ok(userRepository.getByNameEquals(name));
    }


    /**
     * Exists by name equals response entity.
     *
     * @param name the name
     * @return the response entity
     */
    @ApiOperation(value = "existsByNameEquals")
    @GetMapping(value = "existsByNameEquals")
    public ResponseEntity<Boolean> existsByNameEquals(@RequestParam String name) {
        return ResponseEntity.ok(userRepository.existsByNameEquals(name));
    }

    /**
     * Query by name equals response entity.
     *
     * @param name the name
     * @return the response entity
     */
    @ApiOperation(value = "queryByNameEquals")
    @GetMapping(value = "queryByNameEquals")
    public ResponseEntity<List<User>> queryByNameEquals(@RequestParam String name) {
        return ResponseEntity.ok(userRepository.queryByNameEquals(name));
    }

    /**
     * Find distinct by id is in response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @ApiOperation(value = "findDistinctByIdIsIn")
    @GetMapping(value = "findDistinctByIdIsIn")
    public ResponseEntity<List<User>> findDistinctByIdIsIn(@RequestParam String... id) {
        return ResponseEntity.ok(userRepository.findDistinctByIdIsIn(id));
    }

    /**
     * Search by name equals response entity.
     *
     * @param name the name
     * @return the response entity
     */
    @ApiOperation(value = "searchByNameEquals")
    @GetMapping(value = "searchByNameEquals")
    public ResponseEntity<List<User>> searchByNameEquals(@RequestParam String name) {
        return ResponseEntity.ok(userRepository.searchByNameEquals(name));
    }

    /**
     * Stream by name equals response entity.
     *
     * @param name the name
     * @return the response entity
     */
    @ApiOperation(value = "streamByNameEquals")
    @GetMapping(value = "streamByNameEquals")
    @Transactional(readOnly = true)
    public ResponseEntity<Optional<User>> streamByNameEquals(@RequestParam String name) {
        try (Stream<User> stream = userRepository.streamByNameEquals(name)) {
            return ResponseEntity.ok(stream.findFirst());
        }

    }

    @SneakyThrows
    @ApiOperation(value = "searchTop10ByName")
    @GetMapping(value = "searchTop10ByName")
    public ResponseEntity<List<User>> searchTop10ByName(@RequestParam String name) {
        Future<List<User>> future = userRepository.searchTop10ByName(name);
        if (future.isDone()) {
            return ResponseEntity.ok(future.get());
        }
        return null;
    }


}
