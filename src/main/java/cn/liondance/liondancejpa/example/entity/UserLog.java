package cn.liondance.liondancejpa.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author sunwei
 */
@Data
@ApiModel(value = "用户Log")
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class UserLog {
    @Id
    @Column(name = "id", nullable = false, length = 128)
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "guid")
    @ApiModelProperty(name = "id", example = "guid")
    private String        id;
    private String        userInfo;
    @ApiModelProperty(example = "自动生成创建时间")
    @CreatedDate
    private LocalDateTime createTime;
    @ApiModelProperty(example = "自动更新创建时间")
    @LastModifiedDate
    private LocalDateTime updateTime;
    private String        event;

}
