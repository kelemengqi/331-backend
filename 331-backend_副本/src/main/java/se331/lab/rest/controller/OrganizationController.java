package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se331.lab.rest.entity.Organization;
import se331.lab.service.OrganizationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    // POST 请求，保存新组织
    @PostMapping
    public ResponseEntity<Organization> addOrganization(@RequestBody Organization organization) {
        Organization savedOrganization = organizationService.save(organization);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }
}
