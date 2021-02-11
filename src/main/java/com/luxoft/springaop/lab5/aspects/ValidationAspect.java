package com.luxoft.springaop.lab5.aspects;

import com.luxoft.springaop.lab5.exceptions.ValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;

@Aspect
public class ValidationAspect {
	private final static Logger LOG = Logger.getLogger(ValidationAspect.class.getName());

	@Pointcut("execution(* *.setAge(..))")
	public void setAgeMethod() {
	}

	@Before("setAgeMethod()")
	public void checkAge(JoinPoint thisJoinPoint) throws Throwable {
		Object[] methodArgs = thisJoinPoint.getArgs();
		Integer age = (Integer) methodArgs[0];
		if (age > 100) {
			throw new ValidationException("Age cannot be greater than 100. Entered wrong age: " + age);
		}
	}
}
