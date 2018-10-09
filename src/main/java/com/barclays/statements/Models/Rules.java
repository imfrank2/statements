package com.barclays.statements.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Rules")
public class Rules {

    @Id
    public ObjectId _id;

    public String rule;

    public Rules() {
    }

    public Rules(ObjectId _id, String rule) {
        this._id = _id;
        this.rule = rule;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
