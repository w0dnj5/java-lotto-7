package lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

    Lottos lottos = new Lottos(
            List.of(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)), // FIRST
                    new Lotto(List.of(2, 3, 4, 5, 6, 7)), // SECOND
                    new Lotto(List.of(2, 3, 4, 5, 6, 8)), // THIRD
                    new Lotto(List.of(3, 4, 5, 6, 7, 8)), // FOURTH
                    new Lotto(List.of(4, 5, 6, 7, 8, 9)) // FIFTH
            )
    );

    WinningLotto winningLotto = new WinningLotto(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new BonusNumber(7)
    );

    static Stream<Arguments> provideForCountOfRank() {
        return Stream.of(
                Arguments.of(Rank.FIFTH, 1),
                Arguments.of(Rank.FOURTH, 1),
                Arguments.of(Rank.THIRD, 1),
                Arguments.of(Rank.SECOND, 1),
                Arguments.of(Rank.FIRST, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideForCountOfRank")
    void countOfRank(Rank rank, int count) {
        Assertions.assertThat(lottos.countOfRank(rank, winningLotto))
                .isEqualTo(count);
    }
}