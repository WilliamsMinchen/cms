package com.xzjie.cms.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@DynamicInsert
@Table(name = "sys_account")
@SQLDelete(sql = "update sys_account set state = 0 where id = ?")
@Where(clause = "state = 1")
public class Account extends BaseEntity<Account> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    private String name;

    private String nickName;

    private String phone;

    @Column(name = "e_mail")
    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String salt;

    private Integer state;

    @CreationTimestamp
//    @UpdateTimestamp
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    private String remarks;

    @Column(name = "stype", columnDefinition = "char")
    private String stype;

    @Column(name = "sex", columnDefinition = "char")
    private String sex;

    private String card;

    @Column(columnDefinition = "datetime")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDate birtn;

    private Long createUser;

    private Integer locked;

    private Long orgId;

    private String avatar;

    private Long rankId;

    private Integer points;

    @Transient
    private String roleName;

    public String credentialsSalt() {
        return name + salt;
    }

    /**
     * 添加中间表关系
     */
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "AccountRole", joinColumns = {@JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
//    @Transient
//    private Set<Role> roles;



    @Override
    public void copy(Account obj) {
        BeanUtils.copyProperties(obj, this, getIgnoreProperty(obj));
    }
}
