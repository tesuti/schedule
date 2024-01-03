package com.example.controller;

public class AlreadyReservedException extends RuntimeException{

	public AlreadyReservedException(String message) {
		super(message);
	}
}

