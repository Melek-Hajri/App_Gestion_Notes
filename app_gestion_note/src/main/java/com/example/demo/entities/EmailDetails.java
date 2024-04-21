package com.example.demo.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetails {
	
	private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;

}
