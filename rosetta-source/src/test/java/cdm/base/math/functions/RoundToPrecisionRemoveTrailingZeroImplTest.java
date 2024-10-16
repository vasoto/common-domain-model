package cdm.base.math.functions;

import cdm.base.math.RoundingDirectionEnum;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundToPrecisionRemoveTrailingZeroImplTest {
    @Test
    void shouldRoundToNearest5DecimalPlaces() {
        RoundToPrecisionRemoveTrailingZeroImpl func = new RoundToPrecisionRemoveTrailingZeroImpl();
        BigDecimal result = func.doEvaluate(BigDecimal.valueOf(1023.123456789), 5, RoundingDirectionEnum.NEAREST);
        assertEquals("1023.12346", result.toPlainString());
    }

    @Test
    void shouldRoundUpTo5DecimalPlaces() {
        RoundToPrecisionRemoveTrailingZeroImpl func = new RoundToPrecisionRemoveTrailingZeroImpl();
        BigDecimal result = func.doEvaluate(BigDecimal.valueOf(1023.123456789), 5, RoundingDirectionEnum.UP);
        assertEquals("1023.12346", result.toPlainString());
    }

    @Test
    void shouldRoundDownTo5DecimalPlaces() {
        RoundToPrecisionRemoveTrailingZeroImpl func = new RoundToPrecisionRemoveTrailingZeroImpl();
        BigDecimal result = func.doEvaluate(BigDecimal.valueOf(1023.123456789), 5, RoundingDirectionEnum.DOWN);
        assertEquals("1023.12345", result.toPlainString());
    }

    @Test
    void shouldRoundToNearest0DecimalPlaces() {
        RoundToPrecisionRemoveTrailingZeroImpl func = new RoundToPrecisionRemoveTrailingZeroImpl();
        BigDecimal result = func.doEvaluate(BigDecimal.valueOf(1023.123456789), 0, RoundingDirectionEnum.NEAREST);
        assertEquals("1023", result.toPlainString());
    }

    @Test
    void shouldRoundToNearest7DecimalPlaces() {
        RoundToPrecisionRemoveTrailingZeroImpl func = new RoundToPrecisionRemoveTrailingZeroImpl();
        BigDecimal result = func.doEvaluate(BigDecimal.valueOf(1023.1), 7, RoundingDirectionEnum.NEAREST);
        assertEquals("1023.1000000", result.toPlainString());
    }
    
    @Test
    void shouldRoundDownTo5DecimalPlacesRemoveTrailingZero() {
        RoundToPrecisionRemoveTrailingZeroImpl func = new RoundToPrecisionRemoveTrailingZeroImpl();
        BigDecimal result = func.doEvaluate(BigDecimal.valueOf(1023), 5, RoundingDirectionEnum.NEAREST);
        assertEquals("1023", result.toPlainString());
    }

    @Test
    void shouldRoundDownTo4DecimalPlacesRemovingTrailingZeros() {
        RoundToPrecisionRemoveTrailingZeroImpl func = new RoundToPrecisionRemoveTrailingZeroImpl();
        BigDecimal result = func.doEvaluate(BigDecimal.valueOf(999999999), 4, RoundingDirectionEnum.NEAREST);
        assertEquals("99999999", result.toPlainString());
    }
}