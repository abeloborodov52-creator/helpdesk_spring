package com.abeloborodov.helpdesk_spring.dto;

import com.abeloborodov.helpdesk_spring.model.TicketStatus;

public class ChangeStatusRequest {

    private TicketStatus status;

    public ChangeStatusRequest() {
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
