package org.coder.lab0201springauthorizationserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author dongnan
 * @since 2024-10-12
 */
@Getter
@Setter
@TableName("oauth2_authorization_consent")
public class Oauth2AuthorizationConsent implements Serializable {

    private static final long serialVersionUID = 1L;

    private String registeredClientId;

    private String principalName;

    private String authorities;
}
