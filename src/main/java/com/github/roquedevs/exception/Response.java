package com.github.roquedevs.exception;

import java.util.Date;

public record Response(Date timestamp, String message, int statusCode, String details) {
}