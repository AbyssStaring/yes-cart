package org.yes.cart.payment.impl;

import org.apache.commons.lang.SerializationUtils;
import org.yes.cart.payment.dto.Payment;
import org.yes.cart.payment.dto.PaymentGatewayFeature;
import org.yes.cart.payment.dto.impl.PaymentGatewayFeatureImpl;

import java.util.UUID;

/**
 * User: denispavlov
 * Date: 15/10/2015
 * Time: 10:23
 */
public class PostFinanceManualPaymentGatewayImpl extends PostFinancePaymentGatewayImpl {


    private final static PaymentGatewayFeature paymentGatewayFeature = new PaymentGatewayFeatureImpl(
            true, false, true, false,
            false, false, false,
            true, true, true,
            null,
            false, false
    );

    /**
     * RES: AUTH (Capture is configured in PostFinance and thus only manual marker should be supported in YC)
     *
     * @return operation
     */
    protected String getExternalFormOperation() {
        return "RES";
    }

    /**
     * {@inheritDoc}
     */
    public Payment authorizeCapture(final Payment paymentIn) {
        final Payment payment = (Payment) SerializationUtils.clone(paymentIn);
        payment.setTransactionOperation(AUTH);
        payment.setTransactionReferenceId(UUID.randomUUID().toString());
        payment.setTransactionAuthorizationCode(UUID.randomUUID().toString());
        payment.setPaymentProcessorResult(Payment.PAYMENT_STATUS_MANUAL_PROCESSING_REQUIRED);
        payment.setPaymentProcessorBatchSettlement(false);
        return payment;
    }

    /**
     * {@inheritDoc}
     */
    public Payment authorize(final Payment paymentIn) {
        return paymentIn;
    }

    /**
     * {@inheritDoc}
     */
    public String getLabel() {
        return "postFinanceManualPaymentGateway";
    }

    /**
     * {@inheritDoc}
     */
    public PaymentGatewayFeature getPaymentGatewayFeatures() {
        return paymentGatewayFeature;
    }



}