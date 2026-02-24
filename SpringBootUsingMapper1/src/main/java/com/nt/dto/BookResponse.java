package com.nt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
	private String title;//by user
	private String author;//by user
	private double price;//by user
	private String isbn;//set by service layer

}
