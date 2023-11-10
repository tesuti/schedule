package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Event {
	 private String title;

	    /**
	     * カレンダーの開始日付
	     */
	    private String start;

	    /**
	     * カレンダーの終了日付
	     */
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column
		private long id;
	    private String end;
	    private String backgroundColor;
	    private String body;
		public void setBody(String body) {
			this.body = body;
		}
		public String getBody() {
			return body;
		}
		
		
		
		public void setId(long id) {
			this.id = id;
		}
	    public String getTitle() {
	        return title;
	    }
	    public void setTitle(String title) {
	        this.title = title;
	    }
	    public String getStart() {
	        return start;
	    }
	    public void setStart(String start) {
	        this.start = start;
	    }
	    public String getEnd() {
	        return end;
	    }
	    public void setEnd(String end) {
	        this.end = end;
	    }
	    
	    public String getBackgroundColor() {
	        return backgroundColor;
	    }
	    public void setBackgroundColor(String backgroundColor) {
	        this.backgroundColor = backgroundColor;
	    }
}
