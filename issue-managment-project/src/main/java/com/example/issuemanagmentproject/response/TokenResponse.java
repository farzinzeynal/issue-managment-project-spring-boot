package com.example.issuemanagmentproject.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse
{
   private String token;
   private String username;
   private String nameSurename;
}
