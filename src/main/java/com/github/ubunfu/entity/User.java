package com.github.ubunfu.entity;

import lombok.Data;

@Data
class User {
    int id;
    String email;
    String firstName;
    String lastName;
    String avatar;
}
