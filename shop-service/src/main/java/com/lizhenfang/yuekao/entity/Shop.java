package com.lizhenfang.yuekao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "t_shop")
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer province;
    private Integer city;
    private Integer district;


    private Date createtime;

    private Integer price;

    private Integer price2;

    //区间查询时添加的字段
    @Transient
    private Integer pricestart;
    @Transient
    private Integer priceend;

    private String miaosu;

    private String buy;

    private String pic;

    private String isshang;

    @JsonIgnoreProperties("list")
    @OneToOne
    @JoinColumn(name = "province",foreignKey = @ForeignKey(name = "none"),
    insertable = false,updatable = false)
    private Nation province1;

    @JsonIgnoreProperties("list")
    @OneToOne
    @JoinColumn(name = "city",foreignKey = @ForeignKey(name = "none"),
            insertable = false,updatable = false)
    private Nation city1;

    @JsonIgnoreProperties("list")
    @OneToOne
    @JoinColumn(name = "district",foreignKey = @ForeignKey(name = "none"),
            insertable = false,updatable = false)
    private Nation district1;


}
