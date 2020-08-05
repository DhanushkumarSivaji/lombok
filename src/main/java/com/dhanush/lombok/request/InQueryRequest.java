package com.dhanush.lombok.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InQueryRequest {
	
	private List<String> firstNames;

}
