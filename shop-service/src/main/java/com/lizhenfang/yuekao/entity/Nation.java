package com.lizhenfang.yuekao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "t_district")
public class Nation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private  String name;

    private int parent;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent",foreignKey = @ForeignKey(name = "none"),
            insertable = false,updatable = false)
    private List<Nation> list;
}
