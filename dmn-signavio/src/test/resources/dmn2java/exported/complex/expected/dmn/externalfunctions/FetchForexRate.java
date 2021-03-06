
import java.util.*;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = {"decision-with-extension.ftl", "fetchForexRate"})
@com.gs.dmn.runtime.annotation.DRGElement(
    namespace = "",
    name = "fetchForexRate",
    label = "FetchForexRate",
    elementKind = com.gs.dmn.runtime.annotation.DRGElementKind.DECISION,
    expressionKind = com.gs.dmn.runtime.annotation.ExpressionKind.LITERAL_EXPRESSION,
    hitPolicy = com.gs.dmn.runtime.annotation.HitPolicy.UNKNOWN,
    rulesCount = -1
)
public class FetchForexRate extends com.gs.dmn.signavio.runtime.DefaultSignavioBaseDecision {
    public static final com.gs.dmn.runtime.listener.DRGElement DRG_ELEMENT_METADATA = new com.gs.dmn.runtime.listener.DRGElement(
        "",
        "fetchForexRate",
        "FetchForexRate",
        com.gs.dmn.runtime.annotation.DRGElementKind.DECISION,
        com.gs.dmn.runtime.annotation.ExpressionKind.LITERAL_EXPRESSION,
        com.gs.dmn.runtime.annotation.HitPolicy.UNKNOWN,
        -1
    );
    private final IsForexRateRequired isForexRateRequired;

    public FetchForexRate() {
        this(new IsForexRateRequired());
    }

    public FetchForexRate(IsForexRateRequired isForexRateRequired) {
        this.isForexRateRequired = isForexRateRequired;
    }

    public String apply(String derivativeType, String taxChargeType, String transaction, String transactionTaxMetaData, com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_) {
        try {
            return apply(derivativeType, taxChargeType, (transaction != null ? com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(transaction, type.TransactionImpl.class) : null), (transactionTaxMetaData != null ? com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(transactionTaxMetaData, type.TransactionTaxMetaDataImpl.class) : null), annotationSet_, new com.gs.dmn.runtime.listener.LoggingEventListener(LOGGER), new com.gs.dmn.runtime.external.DefaultExternalFunctionExecutor());
        } catch (Exception e) {
            logError("Cannot apply decision 'FetchForexRate'", e);
            return null;
        }
    }

    public String apply(String derivativeType, String taxChargeType, String transaction, String transactionTaxMetaData, com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_, com.gs.dmn.runtime.listener.EventListener eventListener_, com.gs.dmn.runtime.external.ExternalFunctionExecutor externalExecutor_) {
        try {
            return apply(derivativeType, taxChargeType, (transaction != null ? com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(transaction, type.TransactionImpl.class) : null), (transactionTaxMetaData != null ? com.gs.dmn.serialization.JsonSerializer.OBJECT_MAPPER.readValue(transactionTaxMetaData, type.TransactionTaxMetaDataImpl.class) : null), annotationSet_, eventListener_, externalExecutor_);
        } catch (Exception e) {
            logError("Cannot apply decision 'FetchForexRate'", e);
            return null;
        }
    }

    public String apply(String derivativeType, String taxChargeType, type.Transaction transaction, type.TransactionTaxMetaData transactionTaxMetaData, com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_) {
        return apply(derivativeType, taxChargeType, transaction, transactionTaxMetaData, annotationSet_, new com.gs.dmn.runtime.listener.LoggingEventListener(LOGGER), new com.gs.dmn.runtime.external.DefaultExternalFunctionExecutor());
    }

    public String apply(String derivativeType, String taxChargeType, type.Transaction transaction, type.TransactionTaxMetaData transactionTaxMetaData, com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_, com.gs.dmn.runtime.listener.EventListener eventListener_, com.gs.dmn.runtime.external.ExternalFunctionExecutor externalExecutor_) {
        try {
            // Start decision 'fetchForexRate'
            long fetchForexRateStartTime_ = System.currentTimeMillis();
            com.gs.dmn.runtime.listener.Arguments fetchForexRateArguments_ = new com.gs.dmn.runtime.listener.Arguments();
            fetchForexRateArguments_.put("derivativeType", derivativeType);
            fetchForexRateArguments_.put("taxChargeType", taxChargeType);
            fetchForexRateArguments_.put("transaction", transaction);
            fetchForexRateArguments_.put("transactionTaxMetaData", transactionTaxMetaData);
            eventListener_.startDRGElement(DRG_ELEMENT_METADATA, fetchForexRateArguments_);

            // Apply child decisions
            Boolean isForexRateRequired = this.isForexRateRequired.apply(derivativeType, taxChargeType, transactionTaxMetaData, annotationSet_, eventListener_, externalExecutor_);

            // Evaluate decision 'fetchForexRate'
            String output_ = evaluate(isForexRateRequired, transaction, annotationSet_, eventListener_, externalExecutor_);

            // End decision 'fetchForexRate'
            eventListener_.endDRGElement(DRG_ELEMENT_METADATA, fetchForexRateArguments_, output_, (System.currentTimeMillis() - fetchForexRateStartTime_));

            return output_;
        } catch (Exception e) {
            logError("Exception caught in 'fetchForexRate' evaluation", e);
            return null;
        }
    }

    protected String evaluate(Boolean isForexRateRequired, type.Transaction transaction, com.gs.dmn.runtime.annotation.AnnotationSet annotationSet_, com.gs.dmn.runtime.listener.EventListener eventListener_, com.gs.dmn.runtime.external.ExternalFunctionExecutor externalExecutor_) {
        return (String)externalExecutor_.execute("com.gs.opstech.rto.tax.transaction_tax.calculator.ForexRateService", "fetchECBForexRateFor", new Object[] {isForexRateRequired, transaction, annotationSet_, eventListener_, externalExecutor_});
    }
}
