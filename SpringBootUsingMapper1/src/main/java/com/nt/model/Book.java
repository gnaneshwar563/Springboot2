package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private String title;//by user
	@Id
	@GeneratedValue
	private Integer bookId;
	private String author;//by user
	private double price;//by user
	private String isbn;

}
