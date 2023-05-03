package com.josh.userservice.valueObject;

import com.josh.userservice.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseTemplateVO {
        private Users users;
        private Department department;

    }
