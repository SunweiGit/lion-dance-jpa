package cn.liondance.liondancejpa.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author sunwei
 */
@Data
@ApiModel(value = "用户")
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id", nullable = false, length = 64)
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "guid")
    @ApiModelProperty(name = "id", example = "uuid")
    private String id;
    @ApiModelProperty(name = "name", example = "安徽")
    private String name;
    @ApiModelProperty(name = "email", example = "12222@qq.com")
    private String email;
    @ApiModelProperty(name = "nickName")
    private String nickName;

}
