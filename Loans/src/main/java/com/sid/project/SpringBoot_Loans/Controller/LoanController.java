package com.sid.project.SpringBoot_Loans.Controller;

import com.sid.project.SpringBoot_Loans.Constants.LoanConstants;
import com.sid.project.SpringBoot_Loans.DTO.LoanDTO;
import com.sid.project.SpringBoot_Loans.Exception.Response;
import com.sid.project.SpringBoot_Loans.Service.LoanService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/loans")
public class LoanController
{
    @Autowired
    private LoanService loanService;

    @PostMapping("/createLoan")
    public ResponseEntity<Response> createLoan(@Valid @RequestParam
                                               @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                               String mobileNo)
    {
        loanService.createLoan(mobileNo);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new Response(LoanConstants.STATUS_200, LoanConstants.STATUS_201));
    }


    @GetMapping("/fetchLoan")
    public ResponseEntity<LoanDTO> fetchLoanDetails(@RequestParam
                                                     @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                     String mobileNo)
    {
        LoanDTO loanDto = loanService.fetchLoan(mobileNo);
        return ResponseEntity.status(HttpStatus.OK).body(loanDto);
    }

    @PutMapping("/updateLoan")
    public ResponseEntity<Response> updateLoanDetails(@Valid @RequestBody LoanDTO loanDto)
    {
        boolean isUpdated = loanService.updateLoan(loanDto);
        if(isUpdated)
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Response(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new Response(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/deleteLoan")
    public ResponseEntity<Response> deleteLoanDetails(@RequestParam
                                                         @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                         String mobileNo)
    {
        boolean isDeleted = loanService.deleteLoan(mobileNo);
        if(isDeleted)
        {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Response(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new Response(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_DELETE));
        }
    }

    @GetMapping("/test")
    public String test()
    {
        return "Test API..";
    }
}