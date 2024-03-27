package net.project.quanliuser.application.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public class UserDto {

        @NotNull
        private String id;

        @NotBlank
        @Size(max = 150)
        private String userName;

        @NotBlank
        @Size(max = 150)
        private String email;

        private String phonenumber;


    }

