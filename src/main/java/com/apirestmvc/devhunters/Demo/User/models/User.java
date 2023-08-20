package com.apirestmvc.devhunters.Demo.User.models;

import com.apirestmvc.devhunters.Demo.User.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(
			name = "email",
			unique = true
	)
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	Role role;
}
