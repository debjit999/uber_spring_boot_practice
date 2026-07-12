package com.project.uber.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class UberRepository {
    public String SaveStatus(String string) {
        return "From Uber Hi our important Customer "+string;
    }
}
