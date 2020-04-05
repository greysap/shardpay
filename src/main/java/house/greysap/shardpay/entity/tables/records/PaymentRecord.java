/*
 * This file is generated by jOOQ.
 */
package house.greysap.shardpay.entity.tables.records;


import house.greysap.shardpay.entity.tables.Payment;
import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.processing.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PaymentRecord extends UpdatableRecordImpl<PaymentRecord> implements Record4<Long, Integer, Long, Long> {

    private static final long serialVersionUID = 781771637;

    /**
     * Setter for <code>public.payment.payer</code>.
     */
    public void setPayer(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.payment.payer</code>.
     */
    public Long getPayer() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.payment.payment_id</code>.
     */
    public void setPaymentId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.payment.payment_id</code>.
     */
    public Integer getPaymentId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.payment.payee</code>.
     */
    public void setPayee(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.payment.payee</code>.
     */
    public Long getPayee() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.payment.amount</code>.
     */
    public void setAmount(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.payment.amount</code>.
     */
    public Long getAmount() {
        return (Long) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Long, Integer, Long, Long> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Long, Integer, Long, Long> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return Payment.PAYMENT.PAYER;
    }

    @Override
    public Field<Integer> field2() {
        return Payment.PAYMENT.PAYMENT_ID;
    }

    @Override
    public Field<Long> field3() {
        return Payment.PAYMENT.PAYEE;
    }

    @Override
    public Field<Long> field4() {
        return Payment.PAYMENT.AMOUNT;
    }

    @Override
    public Long component1() {
        return getPayer();
    }

    @Override
    public Integer component2() {
        return getPaymentId();
    }

    @Override
    public Long component3() {
        return getPayee();
    }

    @Override
    public Long component4() {
        return getAmount();
    }

    @Override
    public Long value1() {
        return getPayer();
    }

    @Override
    public Integer value2() {
        return getPaymentId();
    }

    @Override
    public Long value3() {
        return getPayee();
    }

    @Override
    public Long value4() {
        return getAmount();
    }

    @Override
    public PaymentRecord value1(Long value) {
        setPayer(value);
        return this;
    }

    @Override
    public PaymentRecord value2(Integer value) {
        setPaymentId(value);
        return this;
    }

    @Override
    public PaymentRecord value3(Long value) {
        setPayee(value);
        return this;
    }

    @Override
    public PaymentRecord value4(Long value) {
        setAmount(value);
        return this;
    }

    @Override
    public PaymentRecord values(Long value1, Integer value2, Long value3, Long value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PaymentRecord
     */
    public PaymentRecord() {
        super(Payment.PAYMENT);
    }

    /**
     * Create a detached, initialised PaymentRecord
     */
    public PaymentRecord(Long payer, Integer paymentId, Long payee, Long amount) {
        super(Payment.PAYMENT);

        set(0, payer);
        set(1, paymentId);
        set(2, payee);
        set(3, amount);
    }
}
