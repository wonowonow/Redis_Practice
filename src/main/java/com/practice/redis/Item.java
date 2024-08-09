package com.practice.redis;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("item") // @Entity 대신
public class Item implements Serializable {

    @Id
    // Id String -> UUID, Long -> Random Long
    private String id;

    private String name;

    private String description;

    private Integer price;

}
