package cn.liondance.liondancejpa.example.repository;

import cn.liondance.liondancejpa.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;


/**
 * 内部基础架构中有个根据方法名的查询生成器机制，对于在存储
 * 库的实体上构建约束查询很有用。该机制方法的前缀有find…By、
 * read…By、query…By、count…By和get…By
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * Stream by name equals stream.
     *
     * @param name the name
     * @return the stream
     */
    Stream<User> streamByNameEquals(String name);

    /**
     * Search by name equals list.
     *
     * @param name the name
     * @return the list
     */
    List<User> searchByNameEquals(String name);

    /**
     * Search by name equals top 10 future.
     *
     * @param name the name
     * @return the future
     */
    @Async
    Future<List<User>> searchTop10ByName(String name);

    /**
     * Query by name equals list.
     *
     * @param name the name
     * @return the list
     */
    List<User> queryByNameEquals(String name);

    /**
     * Find distinct by id is in list.
     *
     * @param id the id
     * @return the list
     */
    List<User> findDistinctByIdIsIn(String... id);

    /**
     * Exists by name equals boolean.
     *
     * @param name the name
     * @return the boolean
     */
    boolean existsByNameEquals(String name);

    /**
     * Gets by name equals.
     *
     * @param name the name
     * @return the by name equals
     */
    List<User> getByNameEquals(String name);

    /**
     * Count by name equals long.
     *
     * @param name the name
     * @return the long
     */
    Long countByNameEquals(String name);

    /**
     * Delete by name equals.
     *
     * @param name the name
     * @return the long
     */
    @Transactional
    Long deleteByNameEquals(String name);

    /**
     * Remove by name equals.
     *
     * @param name the name
     * @return the long
     */
    @Transactional
    Long removeByNameEquals(String name);


    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    List<User> findByName(String name);


    /**
     * Find by name a and email list.
     *
     * @param name  the name
     * @param email the email
     * @return the list
     */
    List<User> findByNameAndEmail(String name, String email);

    /**
     * Find by email in list.
     *
     * @param email the email
     * @return the list
     */
    List<User> findByEmailIn(String... email);


}
