package com.klarna.registry.domain;

import java.io.Serializable;

public class Result<T> implements Serializable
{
    private static final long serialVersionUID = 1L;
    public static final int SUCCESS = 1;
    public static final int ERROR = -1;
    private int status;
    private String message;
    private T output;

    public Result()
    {

    }
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public T getOutput()
    {
        return output;
    }

    public void setOutput(T output)
    {
        this.output = output;
    }

    public Result(int status, String message)
    {
        this.status = status;
        this.message = message;
        this.output = null;
    }

    public Result(int status, String message, T output)
    {
        this.message = message;
        this.status = status;
        this.output = output;
    }

    public boolean isSuccess()
    {
        return Result.SUCCESS == status;
    }

    @Override
    public String toString()
    {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", output=" + output +
                '}';
    }
}
