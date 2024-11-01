package lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    WinningLotto winningLotto = new WinningLotto(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new BonusNumber(7)
    );

    static Stream<Arguments> provideForShouldReturnTrue() {
        return Stream.of(
                Arguments.of(Rank.FIRST, new Lotto(List.of(1, 2, 3, 4, 5, 6)), true),
                Arguments.of(Rank.THIRD, new Lotto(List.of(2, 3, 4, 5, 6, 7)), false),
                Arguments.of(Rank.SECOND, new Lotto(List.of(2, 3, 4, 5, 6, 8)), false),
                Arguments.of(Rank.FIFTH, new Lotto(List.of(3, 4, 5, 6, 7, 8)), false),
                Arguments.of(Rank.FOURTH, new Lotto(List.of(4, 5, 6, 7, 8, 9)), false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideForShouldReturnTrue")
    void shouldReturnTrue(Rank rank, Lotto lotto, boolean result) {
        Assertions.assertThat(rank.matches(winningLotto, lotto)).isEqualTo(result);
    }

}