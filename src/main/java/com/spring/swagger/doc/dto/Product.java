package com.spring.swagger.doc.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@NotNull
	private Long id;

	@NotNull
	@NotEmpty
	private String name;
	private String description;

	@NotNull
	@Min(1L)
	private Long price;

	@NotNull
	private Status status;

}
