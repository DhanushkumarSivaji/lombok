package com.dhanush.lombok.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class InQueryRequest {
	
	private List<String> firstNames;

}
