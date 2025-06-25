package com.koreait.SpringSecurityStudy.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.LongConsumer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userRole {
    private Integer userRoleId;
    private Integer userId;
    private Integer roleId;
    private LocalDateTime ceateDt;
    private LocalDateTime updateDt;


}
