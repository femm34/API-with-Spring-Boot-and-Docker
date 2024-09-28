package com.fecd.games.commons.payload;

public class ResponseMessage {
    public String message;
    public Object data;

    public ResponseMessage(Builder builder) {
        this.message = builder.message;
        this.data = builder.data;
    }

    public ResponseMessage() {
    }

    public ResponseMessage(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public static class Builder {
        private String message;
        private Object data;

        public ResponseMessage.Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public ResponseMessage.Builder setData(Object data) {
            this.data = data;
            return this;
        }

        public ResponseMessage build() {

            return new ResponseMessage(this);
        }
    }
}
